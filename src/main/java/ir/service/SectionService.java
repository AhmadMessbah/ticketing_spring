package ir.service;

import ir.model.entity.Section;

import java.util.List;

public interface SectionService {
    void addSection(Section section);
    void deleteSection(Section section);
    void updateSection(Section section);
    List<Section> findAllSections();
    Section findSectionById(Long id);
    List<Section> findSectionByTitle(String title);
    List<Section> findByParentSection(Section section);
    List<Section> findSectionByTitleParentSection(String title);

}
