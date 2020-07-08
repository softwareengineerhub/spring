package com.app.repository;

import com.app.entity.Site;
import com.app.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository  extends JpaRepository<Site, Integer> {
}
