public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallBack;

    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }

    public Worker(OnTaskErrorListener errorCallBack) {
        this.errorCallBack = errorCallBack;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            callback.onDone("Task " + i + " is done");
        }
    }

    public void startWithError() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                errorCallBack.onError("ERROR |Task " + i + " is not done| ERROR");
            } else {
                errorCallBack.onError("Task " + i + " is done");
            }
        }
    }

}

