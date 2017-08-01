package com.ajb.ehospital.repository;

import com.ajb.ehospital.model.Employee;
import com.ajb.ehospital.model.QEmployee;
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
public interface EmployeeRepository extends MongoRepository<Employee, String>,
        QueryDslPredicateExecutor<Employee>,
        QuerydslBinderCustomizer<QEmployee> {

    @Override
    default void customize(QuerydslBindings bindings, QEmployee carrier) {
        bindings.bind(String.class).first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }

}
