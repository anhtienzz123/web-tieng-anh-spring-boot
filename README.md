# API Web Tiếng Anh - Spring Boot

## API

### Login
- `[POST] /login`: đăng nhập.
  - body: {username: String, password: String}.

### Course
- `[GET] /courses/topics`: lấy danh sách topic.
- `[GET] /courses`: lấy danh sách khóa học từ vựng.
  - params: name: String, topicSlug: String, page: int, size: int.
- `[GET] /courses/:slug`: lấy chi tiết khóa học từ vựng

### Word Note
- `[GET] /user/word-note-categories`: lấy danh sách các danh mục ghi chú.
- `[POST] /user/word-note-categories`: tạo danh mục ghi chú.
  - body: {name: String}.
- `[PUT] /user/word-note-categories/:id`: Đổi tên danh mục ghi chú.
  - body: {name: String}.
- `[DELETE] /user/word-note-categories/:id`: Xóa danh mục ghi chú.
- `[POST] /user/word-note-categories/add-word`: Thêm từ vào danh mục ghi chú.
  - body: {wordNoteCategoryId: int, wordId: int}
