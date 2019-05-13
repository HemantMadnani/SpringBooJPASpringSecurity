package co.in.boot.dao;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseDao<T, ID extends Serializable> extends PagingAndSortingRepository<T, ID> {

}
