package observer;

public interface CheckpointListener {
	
	public void notifyRestoreEvent(CheckpointData data);
	public void notifyCheckpointEvent(CheckpointData data);
	
}
