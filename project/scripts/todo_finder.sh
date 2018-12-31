#!/bin/bash
################################################################################
#   Project: Ermon
#
#   File: todo_finder.sh
#
#   Description: This script searches for "@TODO" strings in any file found
#               under <source_root_dir> (iterated recursively), 
#               and prints them into "./todo_list.txt"
#
#               Usage: $ todo_finder.sh <source_root_dir>
#               <source_root_dir> root directory containing the source files (absoulte path)
#
#   Notes: N/A
#
#   Contact: Alberto Martin Cajal, amartin.glimpse23<AT>gmail.com
#
#   URL: https://github.com/amcajal/ermon
#
#   License: GNU GPL v3.0
#
#   Copyright (C) 2018 Alberto Martin Cajal
#
#   This file is part of Ermon
#
#   Ermon is free software: you can redistribute it and/or modify
#   it under the terms of the GNU General Public License as published by
#   the Free Software Foundation, either version 3 of the License, or
#   (at your option) any later version.
#
#   Ermon is distributed in the hope that it will be useful,
#   but WITHOUT ANY WARRANTY; without even the implied warranty of
#   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#   GNU General Public License for more details.
#
#   You should have received a copy of the GNU General Public License
#   along with this program.  If not, see <http://www.gnu.org/licenses/>.
################################################################################

if [ "$#" -ne 1 ]; then
  echo "Usage: $0 <source_root_dir>"
  exit 1
fi

rm ./todo_list.txt
for file in $(find $1); do 
    result=$(cat $file | grep -i -e @todo -e todo -e@TODO -e TODO) 
    if [ $? -eq 0 ]; then 
        echo "$file \n ========== \n $result \n\n" >> ./todo_list.txt 
    fi
done
