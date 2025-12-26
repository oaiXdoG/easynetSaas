# EasynetSaas API 文档

## 基础信息

- 基础路径：`/api`
- 请求方式：`POST`（文件上传除外）
- 请求格式：`application/json`（文件上传用 `multipart/form-data`）
- 响应格式：`application/json`

## 统一响应结构

```json
{
  "code": 200,
  "message": "success",
  "data": {}
}
```

| 字段 | 类型 | 说明 |
|------|------|------|
| code | Integer | 状态码：200成功，其他失败 |
| message | String | 提示信息 |
| data | Object | 数据 |

## 错误码

| code | 说明 |
|------|------|
| 200 | 成功 |
| 400 | 请求参数错误 |
| 401 | 未登录或Token失效 |
| 403 | 无权限 |
| 404 | 资源不存在 |
| 500 | 服务器错误 |

---

## 一、认证模块

### 1.1 登录

**POST** `/api/auth/login`

**请求：**
```json
{
  "username": "admin",
  "password": "123456"
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
    "userInfo": {
      "id": 1,
      "username": "admin",
      "realName": "超级管理员",
      "avatar": null,
      "isSuperAdmin": true
    }
  }
}
```

### 1.2 登出

**POST** `/api/auth/logout`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": null
}
```

### 1.3 获取当前用户

**POST** `/api/auth/me`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "id": 1,
    "username": "admin",
    "realName": "超级管理员",
    "avatar": null,
    "isSuperAdmin": true
  }
}
```

---

## 二、用户管理（超管）

### 2.1 用户列表

**POST** `/api/user/list`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": [
    {
      "id": 1,
      "username": "admin",
      "email": "admin@example.com",
      "phone": "13800000000",
      "realName": "超级管理员",
      "avatar": null,
      "isSuperAdmin": 1,
      "status": 1,
      "lastLoginAt": "2025-12-26 10:00:00",
      "createdAt": "2025-12-25 00:00:00"
    }
  ]
}
```

### 2.2 创建用户

**POST** `/api/user/create`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "username": "zhangsan",
  "password": "123456",
  "email": "zhangsan@example.com",
  "phone": "13800000001",
  "realName": "张三",
  "status": 1
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "id": 2
  }
}
```

### 2.3 更新用户

**POST** `/api/user/update`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "id": 2,
  "email": "zhangsan@example.com",
  "phone": "13800000001",
  "realName": "张三",
  "avatar": null,
  "status": 1
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": null
}
```

### 2.4 删除用户

**POST** `/api/user/delete`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "id": 2
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": null
}
```

### 2.5 启用/禁用用户

**POST** `/api/user/status`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "id": 2,
  "status": 0
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": null
}
```

---

## 三、项目管理（超管）

### 3.1 项目列表

**POST** `/api/project/list`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": [
    {
      "id": 1,
      "projectName": "项目A",
      "description": "项目描述",
      "ownerId": 2,
      "ownerName": "张三",
      "status": 1,
      "createdAt": "2025-12-25 00:00:00"
    }
  ]
}
```

### 3.2 创建项目

**POST** `/api/project/create`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "projectName": "项目A",
  "description": "项目描述",
  "ownerId": 2
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "id": 1
  }
}
```

### 3.3 更新项目

**POST** `/api/project/update`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "id": 1,
  "projectName": "项目A",
  "description": "项目描述",
  "ownerId": 2,
  "status": 1
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": null
}
```

### 3.4 删除项目

**POST** `/api/project/delete`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "id": 1
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": null
}
```

### 3.5 配置项目菜单

**POST** `/api/project/menus`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "projectId": 1,
  "menuIds": [1, 2, 3, 4]
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": null
}
```

### 3.6 分配用户到项目

**POST** `/api/project/users`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "projectId": 1,
  "userIds": [2, 3, 4]
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": null
}
```

---

## 四、菜单同步（超管）

### 4.1 同步菜单

**POST** `/api/menu/sync`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "groups": [
    {
      "groupCode": "console",
      "groupTitle": "控制台",
      "sortOrder": 1
    }
  ],
  "menus": [
    {
      "groupCode": "console",
      "menuCode": "dashboard",
      "menuName": "数据看板",
      "menuType": 2,
      "icon": "dashboard",
      "path": "/console/dashboard",
      "component": "Dashboard/Index.vue",
      "sortOrder": 1
    }
  ]
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "groupsAdded": 1,
    "groupsUpdated": 0,
    "groupsDeleted": 0,
    "menusAdded": 1,
    "menusUpdated": 0,
    "menusDeleted": 0
  }
}
```

### 4.2 获取所有菜单

**POST** `/api/menu/list`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": [
    {
      "groupCode": "console",
      "groupTitle": "控制台",
      "sortOrder": 1,
      "menus": [
        {
          "id": 1,
          "menuCode": "dashboard",
          "menuName": "数据看板",
          "menuType": 2,
          "icon": "dashboard",
          "path": "/console/dashboard",
          "component": "Dashboard/Index.vue",
          "sortOrder": 1
        }
      ]
    }
  ]
}
```

---

## 五、项目上下文

### 5.1 获取用户项目列表

**POST** `/api/my/projects`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": [
    {
      "projectId": 1,
      "projectName": "项目A",
      "roleName": "管理员"
    }
  ]
}
```

### 5.2 切换当前项目

**POST** `/api/my/switchProject`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "projectId": 1
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "projectId": 1,
    "projectName": "项目A",
    "roleId": 1,
    "roleName": "管理员",
    "menuCodes": ["dashboard", "log_app"],
    "permissions": ["user:view", "user:create"]
  }
}
```

### 5.3 获取当前项目信息

**POST** `/api/my/currentProject`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "projectId": 1,
    "projectName": "项目A",
    "roleId": 1,
    "roleName": "管理员",
    "menuCodes": ["dashboard", "log_app"],
    "permissions": ["user:view", "user:create"]
  }
}
```

---

## 六、成员管理

### 6.1 成员列表

**POST** `/api/member/list`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "projectId": 1
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": [
    {
      "userId": 2,
      "username": "zhangsan",
      "realName": "张三",
      "roleId": 1,
      "roleName": "管理员",
      "status": 1
    }
  ]
}
```

### 6.2 添加成员

**POST** `/api/member/add`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "projectId": 1,
  "userId": 3,
  "roleId": 2
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": null
}
```

### 6.3 移除成员

**POST** `/api/member/remove`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "projectId": 1,
  "userId": 3
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": null
}
```

### 6.4 修改成员角色

**POST** `/api/member/updateRole`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "projectId": 1,
  "userId": 3,
  "roleId": 2
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": null
}
```

---

## 七、角色管理

### 7.1 角色列表

**POST** `/api/role/list`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "projectId": 1
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": [
    {
      "id": 1,
      "roleName": "管理员",
      "description": "项目管理员",
      "status": 1
    }
  ]
}
```

### 7.2 创建角色

**POST** `/api/role/create`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "projectId": 1,
  "roleName": "普通员工",
  "description": "普通员工角色"
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "id": 2
  }
}
```

### 7.3 更新角色

**POST** `/api/role/update`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "id": 2,
  "roleName": "普通员工",
  "description": "普通员工角色",
  "status": 1
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": null
}
```

### 7.4 删除角色

**POST** `/api/role/delete`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "id": 2
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": null
}
```

### 7.5 配置角色菜单

**POST** `/api/role/menus`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "roleId": 2,
  "menuIds": [1, 2, 3]
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": null
}
```

### 7.6 配置角色权限

**POST** `/api/role/permissions`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "roleId": 2,
  "permissionIds": [1, 2, 3]
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": null
}
```

---

## 八、权限管理

### 8.1 权限列表

**POST** `/api/permission/list`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "projectId": 1
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": [
    {
      "id": 1,
      "permissionCode": "user:create",
      "permissionName": "创建用户",
      "description": "允许创建用户",
      "status": 1
    }
  ]
}
```

### 8.2 创建权限

**POST** `/api/permission/create`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "projectId": 1,
  "permissionCode": "user:delete",
  "permissionName": "删除用户",
  "description": "允许删除用户"
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": {
    "id": 2
  }
}
```

### 8.3 更新权限

**POST** `/api/permission/update`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "id": 2,
  "permissionCode": "user:delete",
  "permissionName": "删除用户",
  "description": "允许删除用户",
  "status": 1
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": null
}
```

### 8.4 删除权限

**POST** `/api/permission/delete`

**请求头：**
```
Authorization: Bearer <token>
```

**请求：**
```json
{
  "id": 2
}
```

**响应：**
```json
{
  "code": 200,
  "message": "success",
  "data": null
}
```
