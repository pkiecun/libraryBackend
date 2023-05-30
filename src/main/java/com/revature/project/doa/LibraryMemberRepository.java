package com.revature.project.doa;

import com.revature.project.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryMemberRepository extends JpaRepository<Member, Long>{
}
