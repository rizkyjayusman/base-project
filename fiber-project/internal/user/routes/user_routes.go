package routes

import (
	"example.com/base-project/internal/user/controllers"
	"github.com/gofiber/fiber/v2"
)

func RegisterUserRoutes(app *fiber.App) {
	userGroup := app.Group("/users")
	userGroup.Post("/", controllers.CreateUser)
	userGroup.Get("/", controllers.GetAllUsers)
	userGroup.Get("/:id", controllers.GetUserByID)
	userGroup.Put("/:id", controllers.UpdateUser)
	userGroup.Delete("/:id", controllers.DeleteUser)
}
