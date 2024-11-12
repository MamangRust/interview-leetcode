package main

import "strings"

func simplifyPath(path string) string {
	stack := []string{}

	parts := strings.Split(path, "/")

	for _, part := range parts {
		if part == ".." {
			if len(stack) > 0 {
				stack = stack[:len(stack)-1]
			}
		} else if part != "" && part != "." {
			stack = append(stack, part)
		}
	}

	return "/" + strings.Join(stack, "/")
}
