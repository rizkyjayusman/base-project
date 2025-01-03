package models

import (
	"example.com/base-project/common/utils"
)

type User struct {
	ID          int    `json:"id"`
	Username    string `json:"username"`
	Password    string `json:"password"`
	Email       string `json:"email"`
	PhoneNumber string `json:"phone_number"`
}

var sensitiveDataUtil = utils.SensitiveDataUtil{}

func (u User) SensitiveData() utils.SensitiveData {
	res := new(User)
	res.ID = u.ID
	res.Email = sensitiveDataUtil.MaskValue(u.Email, 4)
	res.Username = sensitiveDataUtil.MaskValue(u.Username, 5)
	res.PhoneNumber = sensitiveDataUtil.MaskValue(u.PhoneNumber, 5)
	return res
}
