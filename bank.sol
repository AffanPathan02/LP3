// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract Bank {

  int bal;

  constructor()  {
    bal = 1;
  }

  function getBalance() public view returns (int) {
    return bal;
  }

  function withdraw(int amt) public {
    require(amt <= bal, "Insufficient balance");
    bal -= amt;
  }

  function deposit(int amt) public {
    bal += amt;
  }
}