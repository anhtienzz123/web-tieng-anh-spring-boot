# API Web Tiếng Anh - Spring Boot

## API

### Login
- `[POST] /login`: đăng nhập.
  - body: {username: String, password: String}.

### Course
- `[GET] /courses/topics`: lấy danh sách topic.
- `[GET] /courses`: lấy danh sách khóa học từ vựng.
  - params: name: String, topicSlug: String, page: int (default: 0), size: int (default: 12) .
- `[GET] /courses/:slug`: lấy chi tiết khóa học từ vựng

### Course Word
- `[GET] /course-words`: lấy từ vựng theo slug khóa học
  - params: courseSlug: String, page: int (default: 0) , size: int (default: 30)

### Word Note
- `[GET] /user/word-note-categories`: lấy danh sách các danh mục ghi chú.
- `[POST] /user/word-note-categories`: tạo danh mục ghi chú.
  - body: {name: String}.
- `[PUT] /user/word-note-categories/:id`: Đổi tên danh mục ghi chú.
  - body: {name: String}.
- `[DELETE] /user/word-note-categories/:id`: Xóa danh mục ghi chú.
- `[POST] /user/word-note-categories/add-word`: Thêm từ vào danh mục ghi chú.
  - body: {wordNoteCategoryId: int, wordId: int}
- `[GET] /user/word-note-categories/:id`: lấy chi tiết danh mục ghi chú.
- `[GET] /user/word-note-categories/review/:id`: ôn tập từ vựng.
  - params:
  	- type: int (mặc định là 0)
  		- 0: 1 câu hỏi và 4 từ trắc nghiệm.
  		- 1: gợi ý và điền từ.
  	- ids: List Integer: Danh sách ids đã ôn tập rồi.
- `[DELETE] /user/word-note-categories/:id/words/:wordId`: xóa từ ra khỏi ghi chú.

### Book
- `[GET] /books`: lấy tên sách và đề thi của sách.

### Exam
- `[GET] /exams/:slug`: lấy câu hỏi của bài thi.
- `[POST] /exams/:slug/result`: kiểm tra kết quả bài thi.
  - body:  Map<Integer, String> answers.
- `[GET] /exams`: lấy tất cả tên và slug của bài thi.
- `[GET] /exams/:slug/parts`: lấy câu hỏi của part theo đề thi.
  - params: type: int (từ 1 - 7).

### Video
- `[GET] /video-categories`: lấy danh mục video.
- `[GET] /videos`: lấy danh sách thông tin tóm tắt video.
  - params: 
  	- categorySlug: String.
  	- timeFrom: long (mặc định là 0): Khoảng thời gian đầu cần tìm.
  	- timeTo: long (mặc định là 0): Khoảng thời gian cuối cần tìm.
  	- level: int (1-7) (mặc định là 0: tìm tất cả): tìm theo level.
  	- page: int (mặc định là 0).
  	- size: int (mặc định là 12).
- `[GET] /videos/:slug`: lấy chi tiết video theo slug.

### Blog
- `[GET] /blog-categories`: lấy danh mục blog.
- `[GET] /blogs`: lấy danh sách thông tin tóm tắt blog.
  - params: 
  	- name: String (mặc định là ""): Tên blog.
  	- categorySlug: String (mặc định là ""): Slug danh mục.
  	- page: int (mặc định là 0).
  	- size: int (mặc định là 12).
- `[GET] /blogs/:slug`: lấy chi tiết blog theo slug.

### Me
- `[GET] /user/me/role`: lấy vai trò của user.

## Api Admin

### Blog
- `[GET] /admin/blogs/:id`: lấy chi tiết blog.
- `[POST] /admin/blogs`: thêm blog.
  - body: {name: String, description: String, content: String, categoryId: Interger}.
- `[PUT] /admin/blogs/:id`: cập nhật blog.
  - body: {name: String, description: String, content: String, categoryId: Interger}.	
- `[DELETE] /admin/blogs/:id`: xóa blog.
- `[PUT] /admin/blogs/:id/image`: cập nhật ảnh cho blog.
  - body: image: File.

### Blog Category
- `[GET] /blog-categories`: lấy danh sách danh mục.
- `[POST] /admin/blogs/categories`: thêm danh mục.
  - body: {name: String}.
- `[PUT] /admin/blogs/categories/:id`: cập nhật danh mục.
  - body: {name: String}.
- `[DELETE] /admin/blogs/categories/:id`: xóa danh mục.

### Book
- `[GET] /books`: lấy danh sách books.
- `[POST] /admin/exams/books`: thêm sách.
  - body: {name: String}.
- `[PUT] /admin/exams/books/:id`: cập nhật sách.
  - body: {name: String}.
- `[DELETE] /admin/exams/books/:id`: xóa sách.
- `[PUT] /admin/exams/books/:id/image`: cập nhật ảnh cho sách.
  - body: image: File.

### Video Category
- `[GET] /video-categories`: lấy danh sách danh mục.
- `[POST] /admin/videos/categories`: thêm danh mục.
  - body: {name: String}.
- `[PUT] /admin/videos/categories/:id`: cập nhật danh mục.
  - body: {name: String}.
- `[DELETE] /admin/videos/categories/:id`: xóa danh mục.
