export class Usuario {

	private _username: String;
	private _password: String;

	constructor(_username: String, _password: String) {
		this._username = _username;
		this._password = _password;
	}
	
	public get username(): String {
        return this._username;
    }

    public set username(username: String) {
        this._username = username;
    }

    public get password(): String {
        return this._password;
    }

    public set password(password: String) {
        this._password = password;
    }
}
