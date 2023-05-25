package com.revature.project.doa;

import com.revature.project.models.LibraryMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryMemberRepository extends JpaRepository<LibraryMember, Long>{
}
