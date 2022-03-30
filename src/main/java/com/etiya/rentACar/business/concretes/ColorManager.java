package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import com.etiya.rentACar.business.responses.carMaintenanceResponses.ListCarMaintenanceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.ColorService;
import com.etiya.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.DeleteColorRequest;
import com.etiya.rentACar.business.requests.colorRequests.UpdateColorRequest;
import com.etiya.rentACar.business.responses.colorResponses.ListColorDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.ColorDao;
import com.etiya.rentACar.entities.Color;

@Service
public class ColorManager implements ColorService {
	private ColorDao colorDao;
	private ModelMapperService modelMapperService;

	public ColorManager(ColorDao colorDao, ModelMapperService modelMapperService) {
		this.colorDao = colorDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateColorRequest createColorRequest) {
        
		
		checkIfIsColorName(createColorRequest.getColorName());
		

		Color color = this.modelMapperService.forRequest()
				.map(createColorRequest, Color.class);

		this.colorDao.save(color);

		return new SuccessResult("COLOR_ADDED");


	}
	

	@Override
	public Result update(UpdateColorRequest updateColorRequest) {

        Color color = this.modelMapperService.forRequest()
        .map(updateColorRequest,Color.class);
        
        this.colorDao.save(color);

		return new SuccessResult("COLOR_UPDATED");

	}
	@Override
	public Result delete(DeleteColorRequest deleteColorRequest) {

		this.colorDao.deleteById(deleteColorRequest.getColorId());

		return new SuccessResult("COLOR_DELETED");


	}


	@Override
	public DataResult<List<ListColorDto>> getAll() {

		List<Color> colors = this.colorDao.findAll();

		List<ListColorDto> response = colors.stream()

				.map(color -> this.modelMapperService.forDto()
				.map(color, ListColorDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ListColorDto>>(response);
	}

	@Override
	public DataResult<List<ListColorDto>> getAllPaged(int pageNo, int pageSize) { // sayfalar

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		List<Color> colors = this.colorDao.findAll(pageable).getContent();

		List<ListColorDto> response = colors.stream()

				.map(color -> this.modelMapperService.forDto()
				.map(color, ListColorDto.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<ListColorDto>>(response);
	}

	private void checkIfIsColorName(String colorName) {

		if (this.colorDao.existsByNameIgnoreCase(colorName)) {
			
			throw new BusinessException("Bu renk daha önce kaydedilmiştir :/");
		}

	}

	
}
