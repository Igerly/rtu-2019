package rtu_2019;

import java.util.Optional;

public class MonadicStyle { // Optional is a Functor

	private static User registerLogin(User user) { // f: User -> User
		user.loginCount++;
		return DB.saveUserToDB(user);
	}
	
	private static Optional<User> login(long id) { // f: long -> Optional<User>
		return DB.getOptionalUser(id)
			.map(MonadicStyle::registerLogin); // .map: (Function: User -> User, Optional<User>) -> Optional<User>
	}
	
	private static Optional<Long> getIdFromInternet() {
		long now = System.currentTimeMillis();
		if (now % 10 == 0)
			return Optional.empty();
		else
			return Optional.of(1L);
	}
	
	public static void main(String[] args) {
		DB.init();
//		Optional<User> result = login(getIdFromInternet()); // Ouch! login() doesn't operate on Optional<Long>
//		Optional<User> result = getIdFromInternet().map(MonadicStyle::login); // Ouch! the result is Optional<Optional<User>>
		Optional<User> result = getIdFromInternet().flatMap(MonadicStyle::login); // Composing getIdFromInternet() and login() despite the fact that the these both return wrapped values
	}
}
