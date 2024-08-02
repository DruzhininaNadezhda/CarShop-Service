package org.example.dto.enums;

public enum RoleUser {
        Admin("Admin"),
        Client("Client"),
        Manager("Manager");
        private final String role;

        public String getRoleUser() {
            return role;
        }

         RoleUser(String role) {
            this.role = role;
        }

        public static RoleUser getRoleUser(String roleUser) {
            if (roleUser == null) return null;
            for (RoleUser role : RoleUser.values()) {
                if (role.role.equals(roleUser)) return role;
            }
            return null;
        }
    }
