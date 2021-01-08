package com.seanroshan.ls.persistence.repository;


import com.seanroshan.ls.persistence.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ITaskRepository extends PagingAndSortingRepository<Task, Long> {

    @Query("select t from Task t where t.name like %?1%")
    List<Task> findByNameMatches(String name);

}
