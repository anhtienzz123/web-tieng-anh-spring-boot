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

### Word Note `/user/word-note-categories`
- `[GET]`: lấy danh sách các danh mục ghi chú.
- `[POST]`: tạo danh mục ghi chú.
  - body: {name: String}.
- `[PUT] /:id`: Đổi tên danh mục ghi chú.
  - body: {name: String}.
- `[DELETE] /:id`: Xóa danh mục ghi chú.
- `[POST] /add-word`: Thêm từ vào danh mục ghi chú.
  - body: {wordNoteCategoryId: int, wordId: int}
- `[GET] /:id`: lấy chi tiết danh mục ghi chú.
- `[GET] /review/:id`: ôn tập từ vựng.
  - params:
  	- type: int (mặc định là 0)
  		- 0: 1 câu hỏi và 4 từ trắc nghiệm.
  		- 1: gợi ý và điền từ.
  	- ids: List Integer: Danh sách ids đã ôn tập rồi.
- `[DELETE] /:id/words/:wordId`: xóa từ ra khỏi ghi chú.

### Book
- `[GET] /books`: lấy tên sách và đề thi của sách.

### Exam `/exams`
- `[GET] /:slug`: lấy câu hỏi của bài thi.
- `[POST] /:slug/result`: kiểm tra kết quả bài thi.
  - body:  Map<Integer, String> answers.
- `[GET]`: lấy tất cả tên và slug của bài thi.
- `[GET] /:slug/parts`: lấy câu hỏi của part theo đề thi.
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

### Me `/user/me`
- `[GET] /role`: lấy vai trò của user.

## Api Admin

### Blog `/admin/blogs`
- `[GET] /:id`: lấy chi tiết blog.
- `[POST]`: thêm blog.
  - body: {name: String, description: String, content: String, categoryId: Interger}.
- `[PUT] /:id`: cập nhật blog.
  - body: {name: String, description: String, content: String, categoryId: Interger}.	
- `[DELETE] /:id`: xóa blog.
- `[PUT] /:id/image`: cập nhật ảnh cho blog.
  - body: image: File.

### Blog Category `/admin/blogs/categories`
- `[POST]`: thêm danh mục.
  - body: {name: String}.
- `[PUT] /:id`: cập nhật danh mục.
  - body: {name: String}.
- `[DELETE] /:id`: xóa danh mục.

### Book `/admin/exams/books`
- `[POST]`: thêm sách.
  - body: {name: String}.
- `[PUT] /:id`: cập nhật sách.
  - body: {name: String}.
- `[DELETE] /:id`: xóa sách.
- `[PUT] /:id/image`: cập nhật ảnh cho sách.
  - body: image: File.

### Video Category `/admin/videos/categories`
- `[POST]`: thêm danh mục.
  - body: {name: String}.
- `[PUT] /:id`: cập nhật danh mục.
  - body: {name: String}.
- `[DELETE] /:id`: xóa danh mục.

### Topic `/admin/courses/topics`
- `[POST]`: thêm topic.
  - body: {name: String}.
- `[PUT] /:id`: cập nhật topic.
  - body: {name: String}.
- `[DELETE] /:id`: xóa topic.

### Word `/admin/courses/words`
- `[GET]`: lấy danh sách word.
  - params:
  	- name: String (mặc định là "").
  	- page: int (mặc định là 0).
  	- size: int (mặc định là 10).
- `[POST]`: thêm word.
  - body: {name: String, mean: String, type: String, pronounce: String, definition: String, example: String}.
- `[PUT] /:id`: cập nhật word.
  - body: {name: String, mean: String, type: String, pronounce: String, definition: String, example: String}.
- `[DELETE] /:id`: xóa word.
- `[PUT] /:id/image`: cập nhật ảnh.
  - body: image: File.
- `[PUT] /:id/sound`: cập nhật âm thanh.
  - body: sound: File.

### Course `/admin/course`
- `[POST]`: thêm course.
  - body: {name: String, description: String, topicId: Integer}.
- `[PUT] /:id`: cập nhật course.
  - body: {name: String, description: String, topicId: Integer}.
- `[DELETE] /:id`: xóa course.
- `[PUT] /:id/image`: cập nhật ảnh.
  - body: image: File.
- `[POST] /:id/course-word`: thêm word vào course.
  - body: {wordId: Integer}.
- `[DELETE] /:id/course-word/:wordId`: xóa word ra khỏi course.

### Video `/admin/videos`
- `[POST]`: thêm video.
  - body: {name: String, duration: int, level: int (1-7), description: String, categoryId: Integer}.
- `[PUT] /:id`: cập nhật video.
  - body: {name: String, duration: int, level: int (1-7), description: String, categoryId: Integer}.
- `[DELETE] /:id`: xóa video.
- `[PUT] /:id/image`: cập nhật ảnh.
  - body: image: File.
- `[PUT] /:id/video`: cập nhật video.
  - body: video: File.

### VideoWord `/admin/videos/words`
- `[POST]`: thêm word.
  - body: {name: String, origin: String, frequency: int, videoId: Integer}.
- `[PUT] /:id`: cập nhật word.
  - body: {name: String, origin: String, frequency: int, videoId: Integer}.
- `[DELETE] /:id`: xóa word.
- `[PUT] /:id/sound`: cập nhật sound.
  - body: sound: File.

### Subtitle `/admin/videos/subtitles`
- `[POST]`: thêm sub.
  - body: {start: long, end: long, content: String, videoId: Integer}.
- `[PUT] /:id`: cập nhật sub.
  - body: {start: long, end: long, content: String}.
- `[DELETE] /:videoId`: xóa sub cuối cùng của video.

