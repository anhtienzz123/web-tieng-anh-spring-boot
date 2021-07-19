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
- `[POST] /user/word-note-categories/review/:id`: ôn tập từ vựng.
  - params:
  	- type: int (mặc định là 0)
  		- 0: 1 câu hỏi và 4 từ trắc nghiệm.
  		- 1: gợi ý và điền từ.
  	- ids: List Integer: Danh sách ids đã ôn tập rồi. 

### Book
- `[GET] /books`: lấy tên sách và đề thi của sách.

### Exam
- `[GET] /exams/:slug`: lấy câu hỏi của bài thi.
- `[POST] /exams/:slug/result`: kiểm tra kết quả bài thi.
  - body:  Map<Integer, String> answers.


