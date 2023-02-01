package Karaokelon.Domain.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface NewSongRepository extends JpaRepository<NewSongEntity, Integer> {
}
