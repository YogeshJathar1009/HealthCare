package com.example.healthcare.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthcare.dto.NutritionInfoDto;
import com.example.healthcare.entity.NutritionInfo;
import com.example.healthcare.repository.FoodRepository;
import com.example.healthcare.repository.NutritionInfoRepository;
import com.example.healthcare.service.NutritionInfoService;
@Service
public class NutritionInfoServiceImpl implements NutritionInfoService {

	@Autowired
    private NutritionInfoRepository nutritionInfoRepository;
    
    @Autowired
    private FoodRepository foodRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public NutritionInfoDto createNutritionInfo(NutritionInfoDto nutritionInfoDto) {
        NutritionInfo nutritionInfo = modelMapper.map(nutritionInfoDto, NutritionInfo.class);
        nutritionInfo.setFood(foodRepository.findById(nutritionInfoDto.getFoodId()).orElse(null));
        NutritionInfo savedNutritionInfo = nutritionInfoRepository.save(nutritionInfo);
        return modelMapper.map(savedNutritionInfo, NutritionInfoDto.class);
    }
    
    @Override
    public NutritionInfoDto updateNutritionInfo(NutritionInfoDto nutritionInfoDto) {
        NutritionInfo existingNutritionInfo = nutritionInfoRepository.findById(nutritionInfoDto.getNutritionInfoId()).orElse(null);
        if (existingNutritionInfo == null) {
            // Handle not found error or throw exception
        }
        
        // Update the existingNutritionInfo with new values from nutritionInfoDto
        
        NutritionInfo updatedNutritionInfo = nutritionInfoRepository.save(existingNutritionInfo);
        return modelMapper.map(updatedNutritionInfo, NutritionInfoDto.class);
    }
    
    @Override
    public void deleteNutritionInfo(Long nutritionInfoId) {
        nutritionInfoRepository.deleteById(nutritionInfoId);
    }
    
    @Override
    public List<NutritionInfoDto> getAllNutritionInfo() {
        List<NutritionInfo> nutritionInfos = nutritionInfoRepository.findAll();
        return nutritionInfos.stream()
                .map(nutritionInfo -> modelMapper.map(nutritionInfo, NutritionInfoDto.class))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<NutritionInfoDto> getNutritionInfoByFood(Long foodId) {
        List<NutritionInfo> nutritionInfos = nutritionInfoRepository.findByFood_Id(foodId);
        return nutritionInfos.stream()
                .map(nutritionInfo -> modelMapper.map(nutritionInfo, NutritionInfoDto.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<NutritionInfoDto> getNutritionInfoWithLowCalories() {
        List<NutritionInfo> nutritionInfos = nutritionInfoRepository.findByCaloriesLessThan(100);
        return mapNutritionInfosToDto(nutritionInfos);
    }

    @Override
    public List<NutritionInfoDto> getNutritionInfoWithLowFat() {
        List<NutritionInfo> nutritionInfos = nutritionInfoRepository.findByFatLessThan(10);
        return mapNutritionInfosToDto(nutritionInfos);
    }

    @Override
    public List<NutritionInfoDto> getNutritionInfoWithHighProtein() {
        List<NutritionInfo> nutritionInfos = nutritionInfoRepository.findByProteinGreaterThan(20);
        return mapNutritionInfosToDto(nutritionInfos);
    }

    @Override
    public List<NutritionInfoDto> getNutritionInfoWithHighCarbohydrates() {
        List<NutritionInfo> nutritionInfos = nutritionInfoRepository.findByCarbohydratesGreaterThan(50);
        return mapNutritionInfosToDto(nutritionInfos);
    }

    private List<NutritionInfoDto> mapNutritionInfosToDto(List<NutritionInfo> nutritionInfos) {
        return nutritionInfos.stream()
                .map(nutritionInfo -> modelMapper.map(nutritionInfo, NutritionInfoDto.class))
                .collect(Collectors.toList());
    }
}
