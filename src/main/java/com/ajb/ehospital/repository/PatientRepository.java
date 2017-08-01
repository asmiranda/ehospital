package com.ajb.ehospital.repository;

import com.ajb.ehospital.model.Patient;
import com.ajb.ehospital.model.QPatient;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

/**
 * Created by aiam on 8/1/2017.
 */
public interface PatientRepository extends MongoRepository<Patient, String>,
        QueryDslPredicateExecutor<Patient>,
        QuerydslBinderCustomizer<QPatient> {

    @Override
    default void customize(QuerydslBindings bindings, QPatient carrier) {
        bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }
}
