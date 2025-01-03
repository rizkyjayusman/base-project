package main

import (
	"example.com/base-project/common/middleware"
	"example.com/base-project/internal/user/routes"
	"github.com/gofiber/fiber/v2"
)

func main() {
	app := fiber.New()

	middleware.RegisterMiddleware(app)
	routes.RegisterUserRoutes(app)

	app.Listen(":3000")
}
