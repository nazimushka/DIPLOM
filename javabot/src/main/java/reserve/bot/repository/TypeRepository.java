package reserve.bot.repository;

import jakarta.annotation.Nonnull;
import org.springframework.data.repository.CrudRepository;
import reserve.bot.models.Type;

import java.util.List;

public interface TypeRepository extends CrudRepository<Type, Long> {

    @Nonnull
    List<Type> findAll();
}
