package com.optibuild.website.repository;

import com.optibuild.website.model.components.SocketCompatibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocketCompatibiltyRepository extends JpaRepository<SocketCompatibility, Long> {
    SocketCompatibility findBySocketType(String socket);
}
