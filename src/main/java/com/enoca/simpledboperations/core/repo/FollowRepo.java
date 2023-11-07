package com.enoca.simpledboperations.core.repo;

import com.enoca.simpledboperations.core.domain.Follow;
import com.enoca.simpledboperations.core.domain.User;
import com.enoca.simpledboperations.core.dto.FollowDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface FollowRepo extends JpaRepository<Follow,Long> {

    @Query("select follow.description as description,follow.image from  Follow follow where  follow.following=:userId")
    List<FollowDto> findAllFollower(@Param("userId") Long userId);

}
