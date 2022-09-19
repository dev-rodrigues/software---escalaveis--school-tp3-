package br.com.devrodrigues.schoolservice.output.database.data;

import br.com.devrodrigues.schoolservice.output.database.models.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentData extends JpaRepository<StudentEntity, Integer> {
}
