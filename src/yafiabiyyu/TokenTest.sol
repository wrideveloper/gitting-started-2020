// SPDX-License-Identifier: GPL-3.0
pragma solidity 0.6.8;

import "./Token.sol";


contract TokenTests is Token {

    uint256 constant private MAX_UINT256 = 2**256 - 1;
    mapping (address => uint256) public balances;
    mapping (address => mapping (address => uint256)) public allowed;

    string public name;
    uint8 public decimals;
    string public symbol;

    constructor() public {
        totalSupply = 20000000;
        name = "DevToken";
        decimals = 2;
        symbol = "DT";
        balances[msg.sender] = totalSupply;
        emit Transfer(address(this),msg.sender,totalSupply);
    }

    function transfer(address _to, uint256 _value) public override returns (bool success){
        require(balances[msg.sender] >= _value,"Saldo Harus Lebih banyak");
        balances[msg.sender] -= _value;
        balances[_to] += _value;
        emit Transfer(msg.sender,_to,_value);
        return true;
    }

    function transferFrom(address _from, address _to, uint256 _value) public override returns(bool success){
        uint256 allowance = allowed[_from][msg.sender];
        require(balances[_from] >= _value && allowance >= _value, "");
        balances[_to] += _value;
        balances[_from] -= _value;
        if(allowance < MAX_UINT256){
            allowed[_from][msg.sender] -= _value;
        }
        emit Transfer(_from,_to,_value);
        return true;
    }

    function balanceOf(address _owner) public override view returns (uint256 balance) {
        return balances[_owner];
    }

    function approve(address _spender, uint256 _value) public override returns (bool success) {
        allowed[msg.sender][_spender] = _value;
        emit Approval(msg.sender, _spender, _value); //solhint-disable-line indent, no-unused-vars
        return true;
    }

    function allowance(address _owner, address _spender) public override view returns (uint256 remaining) {
        return allowed[_owner][_spender];
    }
}