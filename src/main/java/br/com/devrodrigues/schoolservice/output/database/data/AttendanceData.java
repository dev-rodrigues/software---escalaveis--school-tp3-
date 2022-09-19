package br.com.devrodrigues.schoolservice.output.database.data;

import br.com.devrodrigues.schoolservice.output.database.models.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceData extends JpaRepository<AttendanceEntity, Integer> {
}
