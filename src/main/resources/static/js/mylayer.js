/**
 * 二次封装 layer
 * Created by Administrator on 2017/9/6.
 */
$.extend({
    /**
     * 默认消息提示
     * @param message
     * @param icon
     */
    msg : function(message, icon) {
        var cmsg = 'UNKONNW';
        var cicon = 6;
        if (message != null) {
            cmsg = message;
        }
        if (icon != null) {
            cicon = icon;
        }
        layer.msg(cmsg, {
            icon : cicon
        });
    },
    success : function() {
        var message = '操作成功!';
        var successIcon = 1;
        this.msg(message, successIcon);
    },
    fail : function() {
        var message = '操作失败!';
        var successIcon = 2;
        this.msg(message, successIcon)
    },
    /**
     * 默认加载
     * @returns {*|{noBubble}|void}
     */
    load : function() {
        return layer.load(2);
    },
    /**
     * 加载关闭对应层
     * @param index
     * @param message
     * @param icon
     */
    loadMessage : function (index, message, icon) {
        layer.close(index);
        this.msg(message, icon);
    }
});
