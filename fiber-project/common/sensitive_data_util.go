package common

import "strings"

type SensitiveDataUtil struct{}

func (util SensitiveDataUtil) MaskValue(value string, visibleLength int) string {
	if len(value) <= visibleLength {
		return value
	}

	visiblePart := value[:visibleLength]
	//maskedPart := strings.Repeat("*", len(value)-visibleLength)
	maskedPart := strings.Repeat("*", 5)
	return visiblePart + maskedPart
}
