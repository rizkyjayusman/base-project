package services

import (
	"errors"
	"example.com/base-project/internal/user/models"
	"github.com/sirupsen/logrus"
)

var users = []models.User{}
var idCounter = 1

var log = logrus.New()

func CreateUser(user *models.User) *models.User {
	log.Infof("Execute user_service.CreateUser() - parameters: %+v", user.SensitiveData())
	user.ID = idCounter
	idCounter++
	users = append(users, *user)
	return user
}

func GetAllUsers() []models.User {
	log.Infof("Execute user_service.GetAllUsers() - get all user")

	return users
}

func GetUserByID(id int) (*models.User, error) {
	log.Infof("Execute user_service.GetUserByID() - get user by user ID: %d", id)

	for _, user := range users {
		if user.ID == id {
			log.Infof("Execute user_service.GetUserByID() - success retrieve detail user ID: %d", id)
			return &user, nil
		}
	}

	log.Errorf("Execute user_service.UpdateUser() - user ID not found: %d", id)
	return nil, errors.New("user not found")
}

func UpdateUser(id int, updatedUser *models.User) (*models.User, error) {
	log.Infof("Execute user_service.UpdateUser() - update user by user ID: %d", id)
	log.Infof("Execute user_service.UpdateUser() - parameters: %+v", updatedUser.SensitiveData())

	for i, user := range users {
		if user.ID == id {
			users[i].PhoneNumber = updatedUser.PhoneNumber
			log.Infof("Execute user_service.UpdateUser() - success update user ID: %d", id)
			return &users[i], nil
		}
	}

	log.Errorf("Execute user_service.UpdateUser() - user ID not found: %d", id)
	return nil, errors.New("user not found")
}

func DeleteUser(id int) error {
	log.Infof("Execute user_service.DeleteUser() - delete user by user ID: %d", id)

	for i, user := range users {
		if user.ID == id {
			users = append(users[:i], users[i+1:]...)
			log.Infof("Execute user_service.DeleteUser() - success delete user ID: %d", id)
			return nil
		}
	}

	log.Errorf("Execute user_service.DeleteUser() - user ID not found: %d", id)
	return errors.New("user not found")
}
