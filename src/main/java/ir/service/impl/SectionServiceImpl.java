package ir.service.impl;

import ir.model.entity.Section;
import ir.repository.SectionRepository;
import ir.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {
    private final SectionRepository sectionRepository;

    public SectionServiceImpl(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }


    @Override
    public void addSection(Section section) {
        sectionRepository.save(section);

    }

    @Override
    public void deleteSection(Section section) {
        if(section.getChildSectionList().isEmpty()) {
            sectionRepository.delete(section);
        }
    }

    @Override
    public void updateSection(Section section) {
        sectionRepository.save(section);

    }

    @Override
    public List<Section> findAllSections() {
        return sectionRepository.findAll();
    }

    @Override
    public Section findSectionById(Long id) {
        return sectionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Section> findSectionByTitle(String title) {
        return sectionRepository.findByTitleIsLike(title);
    }

    @Override
    public List<Section> findByParentSection(Section section) {
        return sectionRepository.findByParentSectionId(section.getId());
    }

    @Override
    public List<Section> findSectionByTitleParentSection(String title) {
        return sectionRepository.findByParentSection_TitleIsLike(title);
    }


}
