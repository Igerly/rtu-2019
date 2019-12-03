package rtu_2019;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.LongStream;

public class DB {

	private final static Map<Long, User> DB = new HashMap<>();

	public static void init() {
		LongStream.range(1, 11)
			.forEach(id -> DB.put(id, new User(id, 0)));
	}

	public static User getUserFromDB(long id) { // f: long -> User
		return DB.get(id);
	}

	public static Optional<User> getOptionalUser(long id) { // f: long -> Optional<User>
		return Optional.ofNullable(
				DB.get(id));
	}

	public static User saveUserToDB(User user) {
		DB.put(user.id, user);
		
		return user;
	}

}
