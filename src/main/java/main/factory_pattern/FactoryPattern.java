package main.factory_pattern;

public class FactoryPattern {
	public static void main(String[] args) {
		Notification notification = NotificationFactory.createNotification("EMAIL");
		notification.notifyUser("ABC");
	}
}

interface Notification {
	void notifyUser(String message);
}

class EmailNotification implements Notification {

	@Override
	public void notifyUser(String message) {
		System.out.println("Email sent: " + message);
	}
}

class PushNotification implements Notification {

	@Override
	public void notifyUser(String message) {
		System.out.println("Push notification sent: " + message);
	}
}

class SMSNotification implements Notification {

	@Override
	public void notifyUser(String message) {
		System.out.println("SMS sent: " + message);
	}
}

class NotificationFactory {
	public static Notification createNotification(String notificationType) {
		switch (notificationType) {
			case "EMAIL":
				return new EmailNotification();
			case "PUSH":
				return new PushNotification();
			case "SMS":
				return new SMSNotification();
			default:
				return null;
		}
	}
}
