package sh.com.pe.ExpenseManagement.configuration;

import org.modelmapper.ModelMapper;

/**
 *
 * @author shmen
 * @param <T1> clases MODEL
 * @param <T2> clases DTO
 */
public class Mapper<T1, T2> {
    
    private final ModelMapper modelMapper;

    public Mapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public T1 toEntity (T2 dto, Class<T1> clase){
        T1 entity = modelMapper.map(dto, clase);
        return entity;
    }
    
    public T2 toDto (T1 entity, Class<T2> clase){
        T2 dto = modelMapper.map(entity, clase);
        return dto;
    }
    
}
