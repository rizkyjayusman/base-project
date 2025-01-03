package middleware

import (
	"example.com/base-project/common/models"
	"github.com/gofiber/fiber/v2"
)

func ResponseMiddleware(c *fiber.Ctx) error {
	err := c.Next()
	if err != nil {
		c.Status(fiber.StatusInternalServerError).JSON(models.Response{
			Status:  fiber.StatusInternalServerError,
			Message: "Internal Server Error",
			Error:   err.Error(),
		})
		return nil
	}

	statusCode := c.Response().StatusCode()
	body := c.Response().Body()

	var data interface{}
	if len(body) > 0 {
		if err := c.App().Config().JSONDecoder(body, &data); err != nil {
			data = body
		}
	}

	if c.Response().Body() != nil {
		return c.JSON(models.Response{
			Status:  statusCode,
			Message: "Success",
			Data:    data,
		})
	}

	return nil
}
