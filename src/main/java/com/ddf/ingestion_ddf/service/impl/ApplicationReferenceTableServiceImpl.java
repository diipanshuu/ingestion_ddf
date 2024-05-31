package com.ddf.ingestion_ddf.service.impl;

import com.ddf.ingestion_ddf.repository.ApplicationReferenceTableRepository;
import com.ddf.ingestion_ddf.entity.ApplicationReferenceTable;
import com.ddf.ingestion_ddf.response.mappers.ApplicationReferenceTableDTO;
import com.ddf.ingestion_ddf.service.ApplicationReferenceTableService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the {@link ApplicationReferenceTableService} interface.
 * This service provides methods to retrieve application reference table data.
 * It interacts with the {@link ApplicationReferenceTableRepository} to access the data layer.
 *
 * @author Brijesh Rajput
 * @version 1.0
 * @since 20/05/24
 */
@Service
public class ApplicationReferenceTableServiceImpl implements ApplicationReferenceTableService {

    private ApplicationReferenceTableRepository referenceTableRepository;


    /**
     * Constructs a new {@code ApplicationReferenceTableServiceImpl} with the specified repository.
     *
     * @param referenceTableRepository the repository for application reference table data
     */
    public ApplicationReferenceTableServiceImpl(ApplicationReferenceTableRepository referenceTableRepository) {
        this.referenceTableRepository = referenceTableRepository;
    }

    /**
     * Retrieves all application reference table entries sorted by reference order.
     *
     * @return a list of {@link ApplicationReferenceTableDTO} containing the reference table data
     */
    @Override
    public List<ApplicationReferenceTableDTO> getAllReferences() {
        // Retrieve all application reference table entries from the repository
        List<ApplicationReferenceTable> references = referenceTableRepository.findAll();

        // Sort the references based on their reference order
        // Map each reference entity to its corresponding DTO
        // Collect the DTOs into a list and return
        return references.stream()
                .sorted(Comparator.comparing(ApplicationReferenceTable::getReferenceOrder))
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    /**
     * Converts an {@link ApplicationReferenceTable} entity to its corresponding DTO.
     *
     * @param reference the reference table entity to convert
     * @return the DTO representation of the reference table entity
     */
    private ApplicationReferenceTableDTO convertToDto(ApplicationReferenceTable reference) {
        ApplicationReferenceTableDTO dto = new ApplicationReferenceTableDTO();
        // Copy properties from the entity to the DTO
        BeanUtils.copyProperties(reference, dto);
        return dto;
    }

}