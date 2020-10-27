// SPDX-License-Identifier: GPL-3.0
pragma solidity 0.6.8;

abstract contract Token {

	uint256 public totalSupply;

	// @param _owner the address from which the balance will be retrived
	// @return The balance
	function balanceOf(address _owner) public virtual view returns(uint256 balance);

	// @notice send _value token to _to from msg.sender
	// @param _to The address of recipient
	// @param _value The amount of token to be transferred
	// @return Wheter the transfer was successful or not
	function transfer(address _to, uint256 _value) public virtual returns (bool success);

	// @notice send `_value` token to `_to` from `_from` on the condition it is approved by `_from`
    // @param _from The address of the sender
    // @param _to The address of the recipient
    // @param _value The amount of token to be transferred
    // @return Whether the transfer was successful or not
	function transferFrom(address _from, address _to, uint256 _value) public virtual returns (bool success);

	// @notice `msg.sender` approves `_spender` to spend `_value` tokens
    // @param _spender The address of the account able to transfer the tokens
    // @param _value The amount of tokens to be approved for transfer
    // @return Whether the approval was successful or not
	function approve(address _spender, uint256 _value) public virtual returns (bool success);

	// @param _owner The address of the account owning tokens
    // @param _spender The address of the account able to transfer the tokens
    // @return Amount of remaining tokens allowed to spent
	function allowance(address _owner, address _spender) public virtual view returns(uint256 remaining);

	// solhint-disable-next-line no-simple-event-func-name
	event Transfer(address indexed _from, address indexed _to, uint256 _value);
    event Approval(address indexed _owner, address indexed _spender, uint256 _value);
}