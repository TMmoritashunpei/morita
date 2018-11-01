package techma.service.passChangeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import techma.domain.categories.Category;
import techma.repository.passChangeRepository.PassChangeRepository;


@Service
@Transactional
public class PassChangeService {
    @Autowired
    PassChangeRepository passChangeRepository;

    public Category findOne(Integer id) {
        return passChangeRepository.getOne(id);
    }

    public Category update(Category category) {
        return passChangeRepository.save(category);
    }

}
