<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Generator" content="EditPlus®">
    <meta name="Author" content="">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <title>七牛图片上传</title>
</head>
<body>
<div id="editor">
    <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
</div>
</body>
</html>
<script type="application/javascript" src="/static/plugins/wangEditor-3.1.1/release/wangEditor.js"></script>
<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor')
    // 隐藏“网络图片”tab
    editor.customConfig.showLinkImg = false
    // 将图片大小限制为 3M
    editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024
    // 配置服务器端地址
    editor.customConfig.uploadImgServer = '/qiniu/wangEditorUpload'
    //自定义 fileName
    editor.customConfig.uploadFileName = 'files'
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.create()

</script>