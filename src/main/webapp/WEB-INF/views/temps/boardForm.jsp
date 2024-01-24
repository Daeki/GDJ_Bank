<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

                <div class="row gx-5 justify-content-center">
                    <div class="col-lg-11 col-xl-9 col-xxl-8">
                        <form method="POST" enctype="multipart/form-data">
                          <input type="hidden" name="boardNum" value="${boardDTO.boardNum}">
                          <div class="mb-3">
                            <label for="title" class="form-label">Title</label>
                            <input type="text" class="form-control" id="title" value="${boardDTO.boardTitle}" name="boardTitle">
                          </div>
                          <!-- <div class="mb-3">
                            <label for="writer" class="form-label">Writer</label>
                            <input type="text" value="${member.userName}" class="form-control" id="writer" name="boardWriter">
                          </div> -->
                          <div class="mb-3">
                            <label for="contents" class="form-label">Contents</label>
                            <textarea class="form-control" id="contents" rows="3" name="boardContents">${boardDTO.boardContents}</textarea>
                          </div>

                          <div class="mb-3" id="filelist" data-file-count="0" data-file-max="5">
                            <button type="button" class="del">DEL</button>
                            <button type="button" id="fileAdd">파일추가</button>

                          </div>

                          <div class="mb-3">
                            <button class="btn btn-primary">등록</button>
                          </div>
                        </form>
                    </div>
                </div>
    