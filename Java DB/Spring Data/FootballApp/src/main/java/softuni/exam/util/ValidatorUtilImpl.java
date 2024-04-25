package softuni.exam.util;

//import org.hibernate.cfg.NotYetImplementedException;

import org.springframework.stereotype.Component;

import javax.validation.Validation;
import javax.validation.Validator;

@Component
public class ValidatorUtilImpl implements ValidatorUtil {

    private Validator validator;

    public void ValidationUtilImpl() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public ValidatorUtilImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public <E> boolean isValid(E entity) {
        return this.validator.validate(entity).isEmpty();
    }

//    @Autowired
//    private final Validator validator;
//
//    @Autowired
//    public ValidatorUtilImpl(Validator validator) {
//        this.validator = validator;
//    }
//
//    @Override
//    public <E> boolean isValid(E entity) {
//        //TODO Implement me
//        throw  new NotYetImplementedException("Not implemented");
//    }
//
//    @Override
//    public <E> Set<ConstraintViolation<E>> violations(E entity) {
//        //TODO Implement me
//        throw  new NotYetImplementedException("Not implemented");
//    }


}
