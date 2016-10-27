/**
 * Created by renjie on 2015/8/10.
 */

(function(window) {

    ChatEvent.LOGIN_ACK = 1001;
    ChatEvent.SEND_MESSAGE_ACK = 1002;
    ChatEvent.USERLIST = 2001;
    ChatEvent.RECEIVE_MESSAGE = 2002;
    ChatEvent.UNEXPECT_ERROR = 10001;

    function ChatEvent(type, retcode, msg) {
        this.type = type;
        this.retcode = retcode;     // retcode : 0 => success, 1 => fail
        this.msg = msg;
    }

    WebChatClient.UNCONNECTED = 0;
    WebChatClient.CONNECTED = 1;
    WebChatClient.LOGINED = 1;

    function WebChatClient() {
        this.websocket = null;
        this.state = WebChatClient.UNCONNECTED;
        this.chatEventListener = null;
    }

    WebChatClient.prototype.init = function(wsUrl, chatEventListener) {
        this.state = WebChatClient.UNCONNECTED;
        this.chatEventListener = chatEventListener;
        this.websocket = new WebSocket(wsUrl); //创建WebSocket对象
        var self = this;
        this.websocket.onopen = function(evt) {
            self.state = WebChatClient.CONNECTED;
        }
        this.websocket.onmessage = function(evt) {
            var res = JSON.parse(evt.data);
            if ( !res.hasOwnProperty("resp") || !res.hasOwnProperty("resultCode") || !res.hasOwnProperty("datas") ) {
                self.chatEventListener(new ChatEvent(ChatEvent.UNEXPECT_ERROR, 0));
            } else {
                var cmd = res["resp"];
                var retcode = res["resultCode"];
                var datas = res["datas"];
                switch(cmd) {
                    case "login":
                        self.chatEventListener(new ChatEvent(ChatEvent.LOGIN_ACK, retcode, datas));
                        break;
                    case "send_message":
                        self.chatEventListener(new ChatEvent(ChatEvent.SEND_MESSAGE_ACK, retcode, datas));
                        break;
                    case "userlist":
                        self.chatEventListener(new ChatEvent(ChatEvent.USERLIST, retcode, datas));
                        break;
                    case "receive_message":
                        self.chatEventListener(new ChatEvent(ChatEvent.RECEIVE_MESSAGE, retcode, datas));
                        break;
                }
            }
        }
        this.websocket.onerror = function(evt) {
            alert(evt);
        }
    }

    WebChatClient.prototype.login = function(username) {
        if ( this.websocket.readyState == WebSocket.OPEN && this.state == WebChatClient.CONNECTED ) {
            var msgdata = JSON.stringify({req:"login", params:{username:username}});
            this.websocket.send(msgdata);
        }
    }

    WebChatClient.prototype.sendMessage = function(message) {
        if ( this.websocket.readyState == WebSocket.OPEN && this.state == WebChatClient.LOGINED ) {
            var msgdata = JSON.stringify({req:"send_message", params:{message:message}});
            this.websocket.send(msgdata);
        }
    }

    // export
    window.ChatEvent = ChatEvent;
    window.WebChatClient = WebChatClient;

})(window);



