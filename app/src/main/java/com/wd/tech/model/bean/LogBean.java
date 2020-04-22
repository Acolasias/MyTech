package com.wd.tech.model.bean;

/**
 * data:2020/4/21
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class LogBean {

    /**
     * result : {"headPic":"http://mobile.bwstudent.com/images/tech/default/tech.jpg","nickName":"饮酒醉","phone":"13171756569","pwd":"al4l1hmDhk+DlTQ0TJUpKiminv5qiaw/p768ey5RgX2/fXRYiF+Fs2WYRib4dmioVsYPfzUZd4rT1dSVeN30xHBu/zJRt85Sg2+02v+/mH6D0nyHnlDsirWKaoCTayTYzT4RQSytTSyaXKP4gxPsbgPg13f8o1P/Agq/sRWKvPo=","sessionId":"15874546149481378","userId":1378,"userName":"Ou4bfW13171756569","whetherFaceId":0,"whetherVip":2}
     * message : 登录成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class ResultBean {
        /**
         * headPic : http://mobile.bwstudent.com/images/tech/default/tech.jpg
         * nickName : 饮酒醉
         * phone : 13171756569
         * pwd : al4l1hmDhk+DlTQ0TJUpKiminv5qiaw/p768ey5RgX2/fXRYiF+Fs2WYRib4dmioVsYPfzUZd4rT1dSVeN30xHBu/zJRt85Sg2+02v+/mH6D0nyHnlDsirWKaoCTayTYzT4RQSytTSyaXKP4gxPsbgPg13f8o1P/Agq/sRWKvPo=
         * sessionId : 15874546149481378
         * userId : 1378
         * userName : Ou4bfW13171756569
         * whetherFaceId : 0
         * whetherVip : 2
         */

        private String headPic;
        private String nickName;
        private String phone;
        private String pwd;
        private String sessionId;
        private int userId;
        private String userName;
        private int whetherFaceId;
        private int whetherVip;

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getWhetherFaceId() {
            return whetherFaceId;
        }

        public void setWhetherFaceId(int whetherFaceId) {
            this.whetherFaceId = whetherFaceId;
        }

        public int getWhetherVip() {
            return whetherVip;
        }

        public void setWhetherVip(int whetherVip) {
            this.whetherVip = whetherVip;
        }
    }
}
