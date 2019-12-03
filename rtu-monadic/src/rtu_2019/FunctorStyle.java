package rtu_2019;

import java.util.Optional;

public class FunctorStyle { // Optional is a Functor

	private static User registerLogin(User user) { // f: User -> User
		user.loginCount++;
		return DB.saveUserToDB(user);
	}
	
	private static Optional<User> login(long id) { // f: long -> Optional<User>
		return DB.getOptionalUser(id)
			.map(FunctorStyle::registerLogin); // .map: (Function: User -> User, Optional<User>) -> Optional<User>
	}
	
	public static void main(String[] args) {
		DB.init();
		Optional<User> result = login(1);
	}
}
