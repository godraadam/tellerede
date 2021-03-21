package dev.godraadam.untold.assembler;

import java.util.ArrayList;
import java.util.List;

import dev.godraadam.untold.dto.BaseDTO;
import dev.godraadam.untold.model.BaseModel;


public interface GeneralAssembler<D extends BaseDTO, M extends BaseModel> {
    
    M createModel(D dto);
    D createDTO(M model);

    public default List<M> createModelList(List<D> dtos) {
        List<M> ms = new ArrayList<>(dtos.size());
        for (D dto : dtos) {
            ms.add(createModel(dto));
        }
        return ms;
    }

    public default List<D> createDTOList(List<M> models) {
        List<D> dtos = new ArrayList<>(models.size());
        for (M model : models) {
            dtos.add(createDTO(model));
        }
        return dtos;
    }

}
