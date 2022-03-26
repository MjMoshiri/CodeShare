package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CodeService {


    private final CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public Code findCodeById(UUID id) {
        return codeRepository.findCodeById(id);
    }

    public Code save(Code toSave) {
        return codeRepository.save(toSave);
    }

    public List<Code> findLatest() {
        return codeRepository.findTop10BySecretEqualsOrderByDateDesc(Secret.NO);
    }

    public void delete(Code code) {
         codeRepository.delete(code);
    }
}
