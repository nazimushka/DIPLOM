package reserve.bot.repository;

import org.springframework.data.repository.CrudRepository;
import reserve.bot.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
